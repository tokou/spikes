package com.novoda.pianohero;

public class Note {

    static final Note C4 = new Note(60);
    static final Note C4_S = new Note(61);
    static final Note D4 = new Note(62);
    static final Note D4_S = new Note(63);
    static final Note E4 = new Note(64);
    static final Note F4 = new Note(65);
    static final Note F4_S = new Note(66);
    static final Note G4 = new Note(67);
    static final Note G4_S = new Note(68);
    static final Note A4 = new Note(69);
    static final Note A4_S = new Note(70);
    static final Note B4 = new Note(71);
    static final Note C5 = new Note(72);
    static final Note C5_S = new Note(73);
    static final Note D5 = new Note(74);
    static final Note D5_S = new Note(75);
    static final Note E5 = new Note(76);
    static final Note F5 = new Note(77);
    static final Note F5_S = new Note(78);
    static final Note G5 = new Note(79);
    static final Note G5_S = new Note(80);
    static final Note A5 = new Note(81);
    static final Note A5_S = new Note(82);
    static final Note B5 = new Note(83);
    
    private static final int LOWEST_MIDI_NOTE = 0;
    private static final int HIGHEST_MIDI_NOTE = 127;

    private final int midiNoteNumber;

    public Note(int midiNoteNumber) {
        this.midiNoteNumber = checkNotOutOfRange(midiNoteNumber);
    }

    private int checkNotOutOfRange(int midiNoteNumber) {
        if (midiNoteNumber < LOWEST_MIDI_NOTE && midiNoteNumber > HIGHEST_MIDI_NOTE) {
            throw new IllegalArgumentException("MIDI notes range from " + LOWEST_MIDI_NOTE + "-" + HIGHEST_MIDI_NOTE + " inclusive");
        }
        return midiNoteNumber;
    }

    public int midi() {
        return midiNoteNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Note note = (Note) o;
        return midiNoteNumber == note.midiNoteNumber;
    }

    @Override
    public int hashCode() {
        return midiNoteNumber;
    }
}
