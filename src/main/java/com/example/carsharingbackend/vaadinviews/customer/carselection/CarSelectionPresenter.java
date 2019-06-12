package com.example.carsharingbackend.vaadinviews.customer.carselection;

import com.example.carsharingbackend.common.mvp.AbstractPresenter;
import com.example.carsharingbackend.common.mvp.IModel;
import com.example.carsharingbackend.common.mvp.IView;
import com.example.carsharingbackend.entity.carinfo.CarEntity;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import java.util.Collection;


@SpringComponent
@UIScope
public class CarSelectionPresenter extends AbstractPresenter<CarSelectionPresenter.CarSelectionModel, CarSelectionPresenter.CarSelectionView> {

    public interface CarSelectionModel extends IModel {
        Collection<CarEntity> getCars(String filter);
    }

    public interface CarSelectionView extends IView {
        void setData(Collection<CarEntity> collection);
    }

    public CarSelectionPresenter(CarSelectionModel model, CarSelectionView view) {
        super(model, view);
        bind();
    }

    @Override
    protected void bind() {
        view.setData(model.getCars(""));
    }

    public void setFilter(String filter) {
        view.setData(model.getCars(filter));
    }

}
