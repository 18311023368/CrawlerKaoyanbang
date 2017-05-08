package com.nyt.gecco.kaoyanbang.exec;

import java.util.Queue;

/**
 * Created by Administrator on 2017/4/9/009.
 */
public interface ActionQueue {
    ActionQueue getActionQueue();

    void enqueue(Action action);

    void dequeue(Action action);

    void clear();

    Queue<Action> getQueue();
}
