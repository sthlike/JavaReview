/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.leetcode.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 * Implement the following operations of a stack using queues.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Example:
 * <p>
 * MyStack stack = new MyStack();
 * <p>
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * Notes:
 * <p>
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class P0225ImplementStackUsingQueues {
    private Queue<Integer> inQueue = new LinkedList<>();
    private Queue<Integer> outQueue = new LinkedList<>();

    public static void main(String[] args) {
        //P0225ImplementStackUsingQueues myStack = new P0225ImplementStackUsingQueues();
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (!outQueue.isEmpty()) {
            while (!outQueue.isEmpty()) {
                inQueue.add(outQueue.poll());
            }
        }
        outQueue.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (!outQueue.isEmpty()) {
            return outQueue.poll();
        } else {
            while (inQueue.size() > 1) {
                outQueue.add(inQueue.poll());
            }
        }
        Queue<Integer> temp = inQueue;
        inQueue = outQueue;
        outQueue = temp;
        return outQueue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (!outQueue.isEmpty()) {
            return outQueue.peek();
        } else {
            while (inQueue.size() > 1) {
                outQueue.add(inQueue.poll());
            }
        }
        Queue<Integer> temp = inQueue;
        inQueue = outQueue;
        outQueue = temp;
        return outQueue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return inQueue.isEmpty() && outQueue.isEmpty();
    }

    private static class MyStack {

        private Queue<Integer> queue = new LinkedList<>();

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.add(x);
            for (int i = 1; i < queue.size(); i++) {
                queue.add(queue.remove());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue.remove();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
