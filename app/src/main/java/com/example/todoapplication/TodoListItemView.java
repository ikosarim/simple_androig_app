package com.example.todoapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

import static android.graphics.Paint.ANTI_ALIAS_FLAG;

@SuppressLint("AppCompatCustomView")
public class TodoListItemView extends TextView {

    private Paint marginPaint;
    private Paint linePaint;
    private int paperColor;
    private float margin;

    public TodoListItemView(Context context) {
        super(context);
        init();
    }

    public TodoListItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TodoListItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
//        Получить ссылку на таблицу ресурсов
        Resources myResources = getResources();

//        Создать кисти для рисования, которые будут использоваться в методе onDraw
        marginPaint = new Paint(ANTI_ALIAS_FLAG);
        marginPaint.setColor(myResources.getColor(R.color.notepad_margin));
        linePaint = new Paint(ANTI_ALIAS_FLAG);
        linePaint.setColor(myResources.getColor(R.color.notepad_lines));

//        Получить цвет фона и ширину кромки
        paperColor = myResources.getColor(R.color.notepad_paper);
        margin = myResources.getDimension(R.dimen.notepad_margin);
    }

    @Override
    public void onDraw(Canvas canvas) {
//        Фоновый цвет для листа
        canvas.drawColor(paperColor);

//        Нарисовать направляющие линии
        canvas.drawLine(0,0, getMeasuredHeight(), 0, linePaint);
        canvas.drawLine(0, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight(), linePaint);

//        Нарисовать кромку
        canvas.drawLine(margin, 0, margin, getMeasuredHeight(), marginPaint);

//        Переместить текс от кромки
        canvas.save();
        canvas.translate(margin, 0);

//        Использовать TextView для вывода текста
        super.onDraw(canvas);
        canvas.restore();
    }

}
