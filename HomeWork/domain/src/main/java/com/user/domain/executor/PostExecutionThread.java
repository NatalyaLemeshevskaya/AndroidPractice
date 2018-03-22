package com.user.domain.executor;

import io.reactivex.Scheduler;

//этот интерфейс нужно реализовать в презентеншн слои
public interface PostExecutionThread {
     Scheduler getScheduler();
}
