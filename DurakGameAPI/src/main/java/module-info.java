module DurakGameAPI {
    requires StandardCardBB;        // Card type
    requires DurakCardInteractionBB;// to define whether card can defend against attacking card
    requires BoardCardMapBB;        // game board
    requires BlindCardCollectionBB; // game deck
    // todo: ('round', 'players-turn-order')
}