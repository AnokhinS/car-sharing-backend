package com.example.carsharingbackend.carattributes.grid;

import com.example.carsharingbackend.common.AbstractPresenter;
import com.example.carsharingbackend.common.IModel;
import com.example.carsharingbackend.common.IView;
import com.example.carsharingbackend.entity.common.NamedBean;
import com.example.carsharingbackend.services.NamedBeanService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.selection.SelectionListener;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import java.util.Collection;


@SpringComponent
@UIScope
public class GridPresenter extends AbstractPresenter<GridPresenter.GridModel, GridPresenter.GridView> {

    public interface GridModel extends IModel {
        void setService(NamedBeanService s);

        void delete(NamedBean bean);


        void save(NamedBean bean);

        Collection<NamedBean> getAll();

        Collection<NamedBean> getAllStartsWith(String str);

        NamedBean newBean();

    }

    public interface GridView extends IView {

        void setData(Collection<NamedBean> list);

        TextField getFilter();

        Button getAddBtn();

        Button getSaveBtn();

        Button getDeleteBtn();

        void edit(NamedBean bean);

        void setSingleSelectListener(SelectionListener<Grid, NamedBean> listener);

    }


    private NamedBean currentBean;

    public GridPresenter(GridModel model, GridView view) {
        super(model, view);
        bind();
    }

    public void updateService(NamedBeanService service) {
        model.setService(service);
        view.getFilter().clear();
        view.setData(model.getAll());
    }

    @Override
    protected void bind() {



        view.getFilter().addValueChangeListener(e -> view.setData(model.getAllStartsWith(e.getValue())));

        view.getAddBtn().addClickListener(e -> {
            currentBean=model.newBean();
            view.edit(currentBean);
        });

        view.setSingleSelectListener(e -> {
            NamedBean bean = e.getFirstSelectedItem().orElse(model.newBean());
            currentBean=bean;
            view.edit(bean);
        });

        view.getSaveBtn().addClickListener(e -> {
            model.save(currentBean);
            view.setData(model.getAll());
        });

        view.getDeleteBtn().addClickListener(e -> {
            model.delete(currentBean);
            view.setData(model.getAll());
        });
    }

    @Override
    public Component getView() {
        return view.mainLayout();
    }
}
