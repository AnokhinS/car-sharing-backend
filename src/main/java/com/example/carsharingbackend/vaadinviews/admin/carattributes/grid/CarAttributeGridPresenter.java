package com.example.carsharingbackend.vaadinviews.admin.carattributes.grid;

import com.example.carsharingbackend.common.mvp.AbstractPresenter;
import com.example.carsharingbackend.common.mvp.IModel;
import com.example.carsharingbackend.common.mvp.IView;
import com.example.carsharingbackend.entity.common.NamedBean;
import com.example.carsharingbackend.restClients.RestClient;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.selection.SelectionListener;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import java.util.Collection;


@SpringComponent
@UIScope
public class CarAttributeGridPresenter extends AbstractPresenter<CarAttributeGridPresenter.GridModel, CarAttributeGridPresenter.GridView> {

    public interface GridModel extends IModel {
        void setRestNamedBeanClient(RestClient<NamedBean> client);

        void delete(long id);

        void save(NamedBean bean);

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

    public CarAttributeGridPresenter(GridModel model, GridView view) {
        super(model, view);
        bind();
    }

    public void updateService(RestClient<NamedBean> client) {
        model.setRestNamedBeanClient(client);
        view.getFilter().clear();
        view.setData(model.getAllStartsWith(""));
    }

    @Override
    protected void bind() {
        view.getFilter().addValueChangeListener(e -> view.setData(model.getAllStartsWith(e.getValue())));

        view.getAddBtn().addClickListener(e -> {
            currentBean = model.newBean();
            view.edit(currentBean);
        });

        view.setSingleSelectListener(e -> {
            NamedBean bean = e.getFirstSelectedItem().orElse(model.newBean());
            currentBean = bean;
            view.edit(bean);
        });

        view.getSaveBtn().addClickListener(e -> {
            model.save(currentBean);
            view.setData(model.getAllStartsWith(""));
        });

        view.getDeleteBtn().addClickListener(e -> {
            model.delete(currentBean.getId());
            view.setData(model.getAllStartsWith(""));
        });
    }
}
