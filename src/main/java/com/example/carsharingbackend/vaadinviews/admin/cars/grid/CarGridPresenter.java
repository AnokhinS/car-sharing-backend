package com.example.carsharingbackend.vaadinviews.admin.cars.grid;

import com.example.carsharingbackend.common.mvp.AbstractPresenter;
import com.example.carsharingbackend.common.mvp.IModel;
import com.example.carsharingbackend.common.mvp.IView;
import com.example.carsharingbackend.entity.carinfo.CarEntity;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.selection.SelectionListener;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import java.util.Collection;

@SpringComponent
@UIScope
public class CarGridPresenter extends AbstractPresenter<CarGridPresenter.CarGridModel, CarGridPresenter.CarGridView> {

    public interface CarGridModel extends IModel {
        Collection<CarEntity> getAll();

        Collection<CarEntity> getAllWithFilter(String filter);

        void delete(long id);

        void save(CarEntity car);

        CarEntity newBean();
    }

    public interface CarGridView extends IView {

        void setData(Collection<CarEntity> cars);

        Button getAddBtn();

        Button getSaveBtn();

        Button getDeleteBtn();

        void edit(CarEntity car);

        void setSingleSelectListener(SelectionListener<Grid, CarEntity> listener);

        CarEntity getCurrentBean();

    }

    public void setFilter(String filter) {
        view.setData(model.getAllWithFilter(filter));
    }

    public CarGridPresenter(CarGridModel model, CarGridView view) {
        super(model, view);
        bind();
    }


    @Override
    protected void bind() {
        view.setData(model.getAll());
        view.getAddBtn().addClickListener(e -> {
            view.edit(model.newBean());
        });
        view.getDeleteBtn().addClickListener(e -> {
            model.delete(view.getCurrentBean().getId());
            view.setData(model.getAll());
        });
        view.getSaveBtn().addClickListener(e -> {
            model.save(view.getCurrentBean());
            view.setData(model.getAll());
        });
    }
}
