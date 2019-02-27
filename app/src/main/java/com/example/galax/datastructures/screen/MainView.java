package com.example.galax.datastructures.screen;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.galax.datastructures.R;
import com.jakewharton.rxbinding2.view.RxView;

import io.reactivex.Observable;

public class MainView implements MainContract.View {

    private View root;

    private TextView arrayText;
    private TextView arrayElemText;
    private Button arrayBtnGet;
    private Button arrayBtnFind;
    private Button arrayBtnDelete;
    private Button arrayBtnAdd;

    private TextView arrayListText;
    private TextView arrayListElemText;
    private Button arrayListBtnGet;
    private Button arrayListBtnFind;
    private Button arrayListBtnDelete;
    private Button arrayListBtnAdd;

    private TextView linkedListText;
    private TextView linkedListElemText;
    private Button linkedListBtnGet;
    private Button linkedListBtnFind;
    private Button linkedListBtnDelete;
    private Button linkedListBtnAdd;

    private TextView stackText;
    private TextView stackElemText;
    private Button stackBtnGet;
    private Button stackBtnFind;
    private Button stackBtnDelete;
    private Button stackBtnAdd;

    private TextView queueText;
    private TextView queueElemText;
    private Button queueBtnGet;
    private Button queueBtnFind;
    private Button queueBtnDelete;
    private Button queueBtnAdd;


    public MainView(View view) {
        this.root = view;
        initView();
    }

    private void initView() {
        arrayText = root.findViewById(R.id.text_array);
        arrayElemText = root.findViewById(R.id.elem_array);
        arrayBtnGet = root.findViewById(R.id.array_get_btn);
        arrayBtnFind = root.findViewById(R.id.array_find_btn);
        arrayBtnDelete = root.findViewById(R.id.array_delete_btn);
        arrayBtnAdd = root.findViewById(R.id.array_add_btn);

        arrayListText = root.findViewById(R.id.text_array_list);
        arrayListElemText = root.findViewById(R.id.elem_array_list);
        arrayListBtnGet = root.findViewById(R.id.array_list_get_btn);
        arrayListBtnFind = root.findViewById(R.id.array_list_find_btn);
        arrayListBtnDelete = root.findViewById(R.id.array_list_delete_btn);
        arrayListBtnAdd = root.findViewById(R.id.array_list_add_btn);

        linkedListText = root.findViewById(R.id.text_linked_list);
        linkedListElemText = root.findViewById(R.id.elem_linked_list);
        linkedListBtnGet = root.findViewById(R.id.linked_list_get_btn);
        linkedListBtnFind = root.findViewById(R.id.linked_list_find_btn);
        linkedListBtnDelete = root.findViewById(R.id.linked_list_delete_btn);
        linkedListBtnAdd = root.findViewById(R.id.linked_list_add_btn);

        stackText = root.findViewById(R.id.text_stack);
        stackElemText = root.findViewById(R.id.elem_stack);
        stackBtnGet = root.findViewById(R.id.stack_get_btn);
        stackBtnFind = root.findViewById(R.id.stack_find_btn);
        stackBtnDelete = root.findViewById(R.id.stack_delete_btn);
        stackBtnAdd = root.findViewById(R.id.stack_add_btn);

        queueText =root.findViewById(R.id.text_queue);
        queueElemText = root.findViewById(R.id.elem_queue);
        queueBtnGet = root.findViewById(R.id.queue_get_btn);
        queueBtnFind = root.findViewById(R.id.queue_find_btn);
        queueBtnDelete = root.findViewById(R.id.queue_delete_btn);
        queueBtnAdd = root.findViewById(R.id.queue_add_btn);

    }

    @Override
    public void setArrayText(String array) {
        arrayText.setText(array);
    }

    @Override
    public Observable<Object> getBtnArrayAction() {
        return RxView.clicks(arrayBtnGet);
    }

    @Override
    public Observable<Object> findBtnArrayAction() {
        return RxView.clicks(arrayBtnFind);
    }

    @Override
    public Observable<Object> deleteBtnArrayAction() {
        return RxView.clicks(arrayBtnDelete);
    }

    @Override
    public Observable<Object> addBtnArrayAction() {
        return RxView.clicks(arrayBtnAdd);
    }

    @Override
    public void setArrayListText(String array) {
        arrayListText.setText(array);
    }

    @Override
    public Observable<Object> getBtnArrayListAction() {
        return RxView.clicks(arrayListBtnGet);
    }

    @Override
    public Observable<Object> findBtnArrayListAction() {
        return RxView.clicks(arrayListBtnFind);
    }

    @Override
    public Observable<Object> deleteBtnArrayListAction() {
        return RxView.clicks(arrayListBtnDelete);
    }

    @Override
    public Observable<Object> addBtnArrayListAction() {
        return RxView.clicks(arrayListBtnAdd);
    }

    @Override
    public void setLinkedListText(String array) {
        linkedListText.setText(array);
    }

    @Override
    public Observable<Object> getBtnLinkedListAction() {
        return RxView.clicks(linkedListBtnGet);
    }

    @Override
    public Observable<Object> findBtnLinkedListAction() {
        return RxView.clicks(linkedListBtnFind);
    }

    @Override
    public Observable<Object> deleteBtnLinkedListAction() {
        return RxView.clicks(linkedListBtnDelete);
    }

    @Override
    public Observable<Object> addBtnLinkedListAction() {
        return RxView.clicks(linkedListBtnAdd);
    }

    @Override
    public void setStackText(String array) {
        stackText.setText(array);
    }

    @Override
    public Observable<Object> getBtnStackAction() {
        return RxView.clicks(stackBtnGet);
    }

    @Override
    public Observable<Object> findBtnStackAction() {
        return RxView.clicks(stackBtnFind);
    }

    @Override
    public Observable<Object> deleteBtnStackAction() {
        return RxView.clicks(stackBtnDelete);
    }

    @Override
    public Observable<Object> addBtnStackAction() {
        return RxView.clicks(stackBtnAdd);
    }

    @Override
    public void setQueueText(String array) {
        queueText.setText(array);
    }

    @Override
    public Observable<Object> getBtnQueueAction() {
        return RxView.clicks(queueBtnGet);
    }

    @Override
    public Observable<Object> findBtnQueueAction() {
        return RxView.clicks(queueBtnFind);
    }

    @Override
    public Observable<Object> deleteBtnQueueAction() {
        return RxView.clicks(queueBtnDelete);
    }

    @Override
    public Observable<Object> addBtnQueueAction() {
        return RxView.clicks(queueBtnAdd);
    }

    @Override
    public void setArrayElemText(String elem) {
        arrayElemText.setText(elem);
    }

    @Override
    public void setArrayListElemText(String elem) {
        arrayListElemText.setText(elem);
    }

    @Override
    public void setLinkedListElemText(String elem) {
        linkedListElemText.setText(elem);
    }

    @Override
    public void setStackElemText(String elem) {
        stackElemText.setText(elem);
    }

    @Override
    public void setQueueElemText(String elem) {
        queueElemText.setText(elem);
    }
}
