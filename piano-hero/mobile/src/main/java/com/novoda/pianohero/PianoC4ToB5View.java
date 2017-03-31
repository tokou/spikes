package com.novoda.pianohero;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.percent.PercentRelativeLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class PianoC4ToB5View extends PercentRelativeLayout {

    private KeyListener keyListener;

    private View c4View;
    private View d4View;
    private View e4View;
    private View f4View;
    private View g4View;
    private View a4View;
    private View b4View;

    private View c4sView;
    private View d4sView;
    private View f4sView;
    private View g4sView;
    private View a4sView;

    private View c5View;
    private View d5View;
    private View e5View;
    private View f5View;
    private View g5View;
    private View a5View;
    private View b5View;

    private View c5sView;
    private View d5sView;
    private View f5sView;
    private View g5sView;
    private View a5sView;

    public PianoC4ToB5View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        View.inflate(getContext(), R.layout.merge_piano_octave, this);

        c4View = findViewById(R.id.piano_octave_c4);
        d4View = findViewById(R.id.piano_octave_d4);
        e4View = findViewById(R.id.piano_octave_e4);
        f4View = findViewById(R.id.piano_octave_f4);
        g4View = findViewById(R.id.piano_octave_g4);
        a4View = findViewById(R.id.piano_octave_a4);
        b4View = findViewById(R.id.piano_octave_b4);

        c4sView = findViewById(R.id.piano_octave_c4_s);
        d4sView = findViewById(R.id.piano_octave_d4_s);
        f4sView = findViewById(R.id.piano_octave_f4_s);
        g4sView = findViewById(R.id.piano_octave_g4_s);
        a4sView = findViewById(R.id.piano_octave_a4_s);

        c5View = findViewById(R.id.piano_octave_c5);
        d5View = findViewById(R.id.piano_octave_d5);
        e5View = findViewById(R.id.piano_octave_e5);
        f5View = findViewById(R.id.piano_octave_f5);
        g5View = findViewById(R.id.piano_octave_g5);
        a5View = findViewById(R.id.piano_octave_a5);
        b5View = findViewById(R.id.piano_octave_b5);

        c5sView = findViewById(R.id.piano_octave_c5_s);
        d5sView = findViewById(R.id.piano_octave_d5_s);
        f5sView = findViewById(R.id.piano_octave_f5_s);
        g5sView = findViewById(R.id.piano_octave_g5_s);
        a5sView = findViewById(R.id.piano_octave_a5_s);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        int halfBlackKeyWidth = c4sView.getWidth() / 2;
        int blackKeyHeight = c4sView.getHeight();

        c4sView.layout(c4View.getRight() - halfBlackKeyWidth, 0, c4View.getRight() + halfBlackKeyWidth, blackKeyHeight);
        d4sView.layout(d4View.getRight() - halfBlackKeyWidth, 0, d4View.getRight() + halfBlackKeyWidth, blackKeyHeight);
        f4sView.layout(f4View.getRight() - halfBlackKeyWidth, 0, f4View.getRight() + halfBlackKeyWidth, blackKeyHeight);
        g4sView.layout(g4View.getRight() - halfBlackKeyWidth, 0, g4View.getRight() + halfBlackKeyWidth, blackKeyHeight);
        a4sView.layout(a4View.getRight() - halfBlackKeyWidth, 0, a4View.getRight() + halfBlackKeyWidth, blackKeyHeight);

        c5sView.layout(c5View.getRight() - halfBlackKeyWidth, 0, c5View.getRight() + halfBlackKeyWidth, blackKeyHeight);
        d5sView.layout(d5View.getRight() - halfBlackKeyWidth, 0, d5View.getRight() + halfBlackKeyWidth, blackKeyHeight);
        f5sView.layout(f5View.getRight() - halfBlackKeyWidth, 0, f5View.getRight() + halfBlackKeyWidth, blackKeyHeight);
        g5sView.layout(g5View.getRight() - halfBlackKeyWidth, 0, g5View.getRight() + halfBlackKeyWidth, blackKeyHeight);
        a5sView.layout(a5View.getRight() - halfBlackKeyWidth, 0, a5View.getRight() + halfBlackKeyWidth, blackKeyHeight);
    }

    public void attach(KeyListener keyListener) {
        this.keyListener = keyListener;

        bindKey(c4View, Note.C4);
        bindKey(d4View, Note.D4);
        bindKey(e4View, Note.E4);
        bindKey(f4View, Note.F4);
        bindKey(g4View, Note.G4);
        bindKey(a4View, Note.A4);
        bindKey(b4View, Note.B4);

        bindKey(c4sView, Note.C4_S);
        bindKey(d4sView, Note.D4_S);
        bindKey(f4sView, Note.F4_S);
        bindKey(g4sView, Note.G4_S);
        bindKey(a4sView, Note.A4_S);

        bindKey(c5View, Note.C5);
        bindKey(d5View, Note.D5);
        bindKey(e5View, Note.E5);
        bindKey(f5View, Note.F5);
        bindKey(g5View, Note.G5);
        bindKey(a5View, Note.A5);
        bindKey(b5View, Note.B5);

        bindKey(c5sView, Note.C5_S);
        bindKey(d5sView, Note.D5_S);
        bindKey(f5sView, Note.F5_S);
        bindKey(g5sView, Note.G5_S);
        bindKey(a5sView, Note.A5_S);
    }

    public void detachKeyListener() {
        this.keyListener = null;
    }

    private void bindKey(final View keyView, final Note note) {
        keyView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (keyListener == null) {
                    Log.e("!!!", "Did you forget to set the listener?");
                    return;
                }
                keyListener.onClick(note);
            }
        });
    }

    public interface KeyListener {

        void onClick(Note note);
    }
}
