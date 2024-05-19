package com.blocker.cardgames.durakgame.api.table;

import com.blocker.cardgames.durakgame.api.hand.DurakHand;
import com.blocker.cardgames.durakgame.api.hand.DurakHandState;
import com.blocker.cardgames.table.bb.multipleslotstable.MultipleSlotsTable;

import java.util.List;
import java.util.Optional;

public class DurakTable {
    private final MultipleSlotsTable<DurakHand> table;

    public DurakTable(MultipleSlotsTable<DurakHand> table) {
        this.table = table;
    }

    public List<DurakHand> getHands() {
        return table.availableTypes();
    }

    public DurakHand attacker() {
        return getHands()
                .stream()
                .filter(hand -> hand.state() == DurakHandState.Attacking)
                .findFirst()
                .orElseThrow();
    }

    public DurakHand defender() {
        return getHands()
                .stream()
                .filter(hand -> hand.state() == DurakHandState.Defending)
                .findFirst()
                .orElseThrow();
    }

    public Optional<DurakHand> roundLooser() {
        return getHands()
                .stream()
                .filter(DurakHand::isRoundLooser)
                .findFirst();
    }

    public int afterAttacker(int slotId) {
        int retries = table.size();
        do {
            slotId = table.nextId(slotId);
            Optional<DurakHand> next = table.findById(slotId);
            if (next.isPresent() && next.get().state() != DurakHandState.Attacking) {
                return slotId;
            }
        } while (retries-- > 0);
        throw new RuntimeException("Can't set defender");
    }

    public void attacker(int slotId) {
        stateAt(slotId, DurakHandState.Attacking);
    }

    public void defender(int slotId) {
        stateAt(slotId, DurakHandState.Defending);
    }

    private void stateAt(int slotId, DurakHandState durakHandState) {
        table.findOneBy(hand -> hand.slotId() == slotId)
                .ifPresent(hand -> hand.state(durakHandState));
    }

    public boolean join(DurakHand durakHand) {
        return table.join(durakHand);
    }

    public boolean leave(int slotId) {
        return table.leave(slotId);
    }
}
