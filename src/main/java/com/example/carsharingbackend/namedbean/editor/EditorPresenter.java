package com.example.carsharingbackend.namedbean.editor;

import com.example.carsharingbackend.common.AbstractPresenter;
import com.example.carsharingbackend.common.IModel;
import com.example.carsharingbackend.common.IView;
import com.example.carsharingbackend.entity.common.NamedBean;
import com.example.carsharingbackend.namedbean.editor.impl.EditorModelImpl;
import com.example.carsharingbackend.namedbean.editor.impl.EditorViewImpl;
import com.example.carsharingbackend.services.NamedBeanService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;


public class EditorPresenter extends AbstractPresenter<EditorPresenter.EditorModel, EditorPresenter.EditorView> {

    public interface EditorModel extends IModel{
        void setService(NamedBeanService s);
        void save(NamedBean bean);
        void delete(NamedBean bean);
    }

    public interface EditorView extends IView, KeyNotifier {
        Button getSaveBtn();
        Button getDeleteBtn();
        void edit(NamedBean bean);
        NamedBean getBean();
    }

    public EditorPresenter() {
        super(new EditorModelImpl(),new EditorViewImpl());
        bind();
    }


    public void updateService(NamedBeanService s){
        model.setService(s);
    }


    @Override
    protected void bind() {
        view.getSaveBtn().addClickListener(e->{
           model.save(view.getBean());
        });

        view.getDeleteBtn().addClickListener(e->{
           model.delete(view.getBean());
        });
    }

    public void edit(NamedBean bean){
        view.edit(bean);
    }

    @Override
    public Component getView() {
        return view.mainLayout();
    }

    public void setSelectedBean(NamedBean bean){
        view.edit(bean);
    }

    public void addSaveClickListener(ComponentEventListener listener){
        view.getSaveBtn().addClickListener(listener);
    }

    public void addDelClickListener(ComponentEventListener listener){
        view.getDeleteBtn().addClickListener(listener);
    }

}
