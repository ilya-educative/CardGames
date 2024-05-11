module DurakGameAPI {
    requires StandardCardBB;        // Card type
    requires DurakCardInteractionBB;// to define whether card can defend against attacking card
    requires BlindCardCollectionBB; // game deck
    requires CardMapBB;             // game board
    requires TurnBasedRoundBB;      // game round
}