package com.example.snakeladder.model;

public enum CarrierType {

    SNAKE{
        @Override
        public int nextPosition(int currentPosition, int offset) {
            return currentPosition - offset;
        }
    },

    LADDER {
        @Override
        public int nextPosition(int currentPosition, int offset) {
            return currentPosition + offset;
        }
    };

    public abstract int nextPosition(int currentPosition, int offset);
}
