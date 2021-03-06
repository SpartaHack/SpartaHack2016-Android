package com.spartahack.spartahack17.Presenter;

import com.spartahack.spartahack17.Model.Event;
import com.spartahack.spartahack17.Retrofit.SpartaHackAPIService;
import com.spartahack.spartahack17.View.ScheduleView;

import org.joda.time.DateTimeComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by memuyskens on 10/16/16.
 * SpartaHack-Android
 */
public class SchedulePresenter extends RxPresenter<ScheduleView, ArrayList<Event>> implements Comparator<Event> {

    private static final String TAG = "SchedulePresenter";

    public void updateEvents() {
        if (isViewAttached()) {
            getView().showLoading();
        }

        Observable observable = SpartaHackAPIService.INSTANCE.getRestAdapter().getSchedule()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());

        subscribe(observable);
    }

    @Override public int compare(Event lhs, Event rhs) {
        return DateTimeComparator.getInstance().compare(lhs.getTime(), rhs.getTime());
    }

    @Override void onError(Throwable e) {
        if (isViewAttached()) {
            getView().onError(e.toString());
        }
    }

    @Override void onNext(ArrayList<Event> events) {
        Collections.sort(events, this);
        if (isViewAttached()) {
            getView().showEvents(events);
        }
    }
}
