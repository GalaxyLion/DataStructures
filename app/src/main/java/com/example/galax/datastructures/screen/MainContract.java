package com.example.galax.datastructures.screen;

import io.reactivex.Observable;

public interface MainContract {
    interface View{
        void setArrayText(String array);
        void setArrayElemText(String elem);
        Observable <Object> getBtnArrayAction();
        Observable <Object> findBtnArrayAction();
        Observable <Object> deleteBtnArrayAction();
        Observable <Object> addBtnArrayAction();

        void setArrayListText(String array);
        void setArrayListElemText(String elem);
        Observable <Object> getBtnArrayListAction();
        Observable <Object> findBtnArrayListAction();
        Observable <Object> deleteBtnArrayListAction();
        Observable <Object> addBtnArrayListAction();

        void setLinkedListText(String array);
        void setLinkedListElemText(String elem);
        Observable <Object> getBtnLinkedListAction();
        Observable <Object> findBtnLinkedListAction();
        Observable <Object> deleteBtnLinkedListAction();
        Observable <Object> addBtnLinkedListAction();

        void setStackText(String array);
        void setStackElemText(String elem);
        Observable <Object> getBtnStackAction();
        Observable <Object> findBtnStackAction();
        Observable <Object> deleteBtnStackAction();
        Observable <Object> addBtnStackAction();

        void setQueueText(String array);
        void setQueueElemText(String elem);
        Observable <Object> getBtnQueueAction();
        Observable <Object> findBtnQueueAction();
        Observable <Object> deleteBtnQueueAction();
        Observable <Object> addBtnQueueAction();

    }

    interface Presenter{
        void start(View view);
        void stop();
    }
}
