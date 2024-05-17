package com.blocker.cardgames.durakgame.api.master;

public final class DurakGameMaster implements Runnable {
    @Override public void run() {

        // Match Setup:
        // ------------------------------------
        // shuffleDeck + broadcast(allInMatch)
        // setTrump + broadcast(allInMatch)

        do {

            // Round Setup:
            // ------------------------------------
            // split cards from deck to hands + broadcast(allInMatch)
            // setAttacker + broadcast(allInMatch)
            // setDefender + broadcast(allInMatch)
            // clearRoundLooser
            // addHandToTurns                               // not needed if notifyAboutAllowedActions is used

            while (true/* end round condition */) {         // every 'Attack' & 'Wait' hands 'Pass'

                // Round gameplay:
                // ------------------------------------
                // getNextHandFromTurns                     // not needed if notifyAboutAllowedActions is used. Can be changed to getAttacker()
                // getAllowedActions + broadcast(thisHand)
                // waitForActionFromHand                    // notifies hand/hand's that
                // performAction + broadcast(allInMatch)    // perform action in separate thread
                // updateHandTurns                          // not needed if
            }

            // clearBoardAfterRound

        } while (true/* end game condition */); // depends on rules
    }
}
