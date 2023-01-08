package com.example.overlapped;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.util.Collection;
import java.util.HashSet;

public class EventDecorator implements DayViewDecorator {

    private Drawable highlightDrawable;
    private final int color;
    private Context context;
    private final HashSet<CalendarDay> dates;

    public EventDecorator(int color, Collection<CalendarDay> dates, Context context) {
        this.color = color;
        this.dates = new HashSet<>(dates);
        this.context = context;
        highlightDrawable = this.context.getResources().getDrawable(R.drawable.circlebackground);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        for (CalendarDay x : dates){
            if (x.getDay() == day.getDay() && x.getMonth() == day.getMonth() + 1 && x.getYear() == day.getYear()){
                return true;
            }
        }
        return false;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setBackgroundDrawable(highlightDrawable);
        view.addSpan(new ForegroundColorSpan(Color.WHITE));
        view.addSpan(new StyleSpan(Typeface.BOLD));
        view.addSpan(new RelativeSizeSpan(1.5f));
    }
}
