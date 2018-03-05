package com.natallialemiasheuskaya.homework7;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public interface PublishContract {

    Observable<Integer> getObservable();

}
