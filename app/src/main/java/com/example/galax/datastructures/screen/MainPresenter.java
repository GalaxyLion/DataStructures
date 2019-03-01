package com.example.galax.datastructures.screen;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

import io.reactivex.disposables.CompositeDisposable;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private CompositeDisposable subscriptions;
    private int[] array;
    private List<Integer> arrayList;
    private List<Integer> linkedList;
    private Stack<Integer> stack;
    private Queue<Integer> queue;
    private Random random;
    private final int ADD_ELEM = 5;
    private final int FIND_ELEM = 5;



    @Override
    public void start(MainContract.View view) {
        this.view = view;
        subscriptions = new CompositeDisposable();

        array = new int[10];
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        stack = new Stack<>();
        queue = new ArrayDeque<>();
        random = new Random();

        initArray();
        initArrayList();
        initLinkedList();
        initStack();
        initQueue();

        initActions();

    }

    private void initQueue() {
        for (int i = 0; i < 10; i++) {
            queue.add(random.nextInt(i+1));
        }
        view.setQueueText(queue.toString());
    }

    private void initStack() {
        for (int i = 0; i < 10; i++) {
            stack.push(random.nextInt(i+1));
        }
        view.setStackText(stack.toString());
    }


    private void initLinkedList() {
        for (int i = 0; i < 10; i++) {
            linkedList.add(random.nextInt(i+1));
        }
        view.setLinkedListText(linkedList.toString());
    }

    private void initArrayList() {
        for (int i = 0; i < 10; i++) {
            arrayList.add(random.nextInt(i+1));
        }
        view.setArrayListText(arrayList.toString());
    }

    private void initArray() {
        for (int i = 0; i < array.length-1; i++) {
            array[i] = random.nextInt(i+1);
        }
        view.setArrayText(Arrays.toString(array));
    }

    private void initActions() {

        //ARRAY
        subscriptions.add(view.getBtnArrayAction()
        .subscribe(
                o->{
                    
                    if(array != null && array.length > 0) {
                        view.setArrayElemText(String.valueOf(array[0]));
                    }else {
                        view.setArrayElemText("Must include 1 or more elements");
                    }
                }
        ));

        subscriptions.add(view.findBtnArrayAction().subscribe(
                o->{

                        view.setArrayElemText(findElem(array,FIND_ELEM));

                }
        ));

        subscriptions.add(view.deleteBtnArrayAction().subscribe(
                o -> {
                    if(array.length >= 1){
                        view.setArrayElemText("Deleted elem " + String.valueOf(array[0]));
                        array = removeTheElement(array,0);
                        view.setArrayText(Arrays.toString(array));

                    }else{
                        view.setArrayElemText("Array must contains 1 or more elements");
                    }
                }
        ));

        subscriptions.add(view.addBtnArrayAction().subscribe(
                o->{
                    if(array.length >= 0){
                        view.setArrayElemText("Add elem " + ADD_ELEM);
                        array = addElem(array,ADD_ELEM);
                        view.setArrayText(Arrays.toString(array));
                    }else{
                        view.setArrayElemText("Array must contains 1 or more elements");
                    }
                }
        ));

        //ARRAY LIST
        subscriptions.add(view.getBtnArrayListAction().subscribe(
                o -> {
                    if(arrayList != null && arrayList.size() > 0) {
                        view.setArrayListElemText(arrayList.get(0).toString());
                    }else {
                        view.setArrayListText("Must include 1 or more elements");
                    }
                }
        ));

        subscriptions.add(view.findBtnArrayListAction().subscribe(
                o -> {
                    if(arrayList != null && arrayList.contains(FIND_ELEM)){
                        view.setArrayListElemText(String.valueOf(arrayList.indexOf(FIND_ELEM)));
                    }else{
                        view.setArrayListElemText("Not contains");
                    }
                }
        ));

        subscriptions.add(view.deleteBtnArrayListAction().subscribe(
                o -> {
                    if (arrayList.size()>=1){
                        view.setArrayListElemText("Removing " + String.valueOf(arrayList.get(0)));
                        arrayList.remove(0);
                        view.setArrayListText(arrayList.toString());
                    }else{
                        view.setArrayListElemText("ArrayList must contains 1 or more elements");
                    }
                }
        ));

        subscriptions.add(view.addBtnArrayListAction().subscribe(
                o -> {
                    if(arrayList.size()>=0){
                        view.setArrayListElemText("Add elem " + ADD_ELEM);
                        arrayList.add(ADD_ELEM);
                        view.setArrayListText(arrayList.toString());
                    }else{
                        view.setArrayListElemText("ArrayList must contains 1 or more elements");
                    }
                }
        ));

        //LINKED LIST
        subscriptions.add(view.getBtnLinkedListAction().subscribe(
                o -> {
                    if(linkedList != null && linkedList.size() > 0){
                        view.setLinkedListElemText(linkedList.get(0).toString());
                    }else {
                        view.setLinkedListElemText("Must include 1 or more elements");
                    }
                }
        ));

        subscriptions.add(view.findBtnLinkedListAction().subscribe(
                o -> {
                    if(linkedList!= null && linkedList.contains(FIND_ELEM)){
                        view.setLinkedListElemText(String.valueOf(linkedList.indexOf(FIND_ELEM)));
                    }else{
                        view.setLinkedListElemText("Not contains");
                    }
                }
        ));

        subscriptions.add(view.deleteBtnLinkedListAction().subscribe(
                o -> {
                    if(linkedList.size()>=1){
                        view.setLinkedListElemText("Removing " + linkedList.get(0).toString());
                        linkedList.remove(0);
                        view.setLinkedListText(linkedList.toString());
                    }else{
                        view.setLinkedListElemText("LinkedList must contains 1 or more elements");
                    }
                }
        ));

        subscriptions.add(view.addBtnLinkedListAction().subscribe(
                o -> {
                    if(linkedList.size()>=0){
                        view.setLinkedListElemText("Add elem " + ADD_ELEM);
                        linkedList.add(ADD_ELEM);
                        view.setLinkedListText(linkedList.toString());
                    }else{
                        view.setLinkedListElemText("LinkedList must contains 1 or more elements");
                    }
                }
        ));

        //STACK
        subscriptions.add(view.getBtnStackAction().subscribe(
                o -> {
                    if(stack != null && stack.size() > 0){
                        view.setStackElemText(String.valueOf(stack.get(0)));
                    }else {
                        view.setStackElemText("Must include 1 or more elements");
                    }
                }
        ));

        subscriptions.add(view.findBtnStackAction().subscribe(
                o -> {
                    if(stack != null && stack.contains(FIND_ELEM)){
                        view.setStackElemText(String.valueOf(stack.indexOf(FIND_ELEM)));
                    }else{
                        view.setStackElemText("Not contains");
                    }
                }
        ));

        subscriptions.add(view.deleteBtnStackAction().subscribe(
                o -> {
                    if(stack.size()>=1){
                        view.setStackElemText("Removing " + String.valueOf(stack.pop()));
                        view.setStackText(stack.toString());
                    }else {
                        view.setStackElemText("Stack must includes 1 or more elements");
                    }
                }
        ));

        subscriptions.add(view.addBtnStackAction().subscribe(
                o->{
                    if(stack.size()>=0){
                        view.setStackElemText("Add elem " + String.valueOf(stack.push(ADD_ELEM)));
                        view.setStackText(stack.toString());
                    }else {
                        view.setStackElemText("Stack must includes 1 or more elements");
                    }
                }
        ));

        //QUEUE
        subscriptions.add(view.getBtnQueueAction().subscribe(
                o -> {
                    if(queue!= null && queue.size() > 0){
                        view.setQueueElemText(String.valueOf(queue.peek()));
                    }else {
                        view.setQueueElemText("Must include 1 or more elements");
                    }
                }
        ));

        subscriptions.add(view.findBtnQueueAction().subscribe(
                o -> {
                    if(queue != null && queue.contains(FIND_ELEM)){
                        view.setQueueElemText("Contains, but queue can't get index");
                    }else{
                        view.setQueueElemText("Not contains");
                    }
                }
        ));

        subscriptions.add(view.deleteBtnQueueAction().subscribe(
                o -> {
                    if(queue.size()>=1){
                        view.setQueueElemText("Removing " + String.valueOf(queue.remove()));
                        view.setQueueText(queue.toString());
                    }else {
                        view.setQueueText("Queue must includes 1 or more elements");
                    }
                }
        ));

        subscriptions.add(view.addBtnQueueAction().subscribe(
                o->{
                    if(queue.size()>=0){
                        view.setQueueText("Add elem " + ADD_ELEM);
                        queue.offer(ADD_ELEM);
                        view.setQueueText(queue.toString());
                    }else {
                        view.setQueueText("Queue must includes 1 or more elements");
                    }
                }
        ));



    }

    private String findElem(int [] array, int element){

        for (int i = 0; i < array.length; i++) {
            if(array[i] == element){
                return  "Element at index " + i;
            }
        }
        return "Not match elem";
    }

    private int[] removeTheElement(int[] arr,
                                         int index)
    {

        if (arr == null
                || index < 0
                || index >= arr.length) {

            return arr;
        }

        int[] anotherArray = new int[arr.length - 1];

        for (int i = 0, k = 0; i < arr.length; i++) {

            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }

        return anotherArray;
    }

    private int[] addElem(int[] originalArray, int newItem)
    {
        int currentSize = originalArray.length;
        int newSize = currentSize + 1;
        int[] tempArray = new int[ newSize ];
        for (int i=0; i < currentSize; i++)
        {
            tempArray[i] = originalArray [i];
        }
        tempArray[newSize- 1] = newItem;
        return tempArray;
    }



    @Override
    public void stop() {
        subscriptions.dispose();
        subscriptions = null;
    }
}
