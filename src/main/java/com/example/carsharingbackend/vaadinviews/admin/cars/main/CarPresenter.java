package com.example.carsharingbackend.vaadinviews.admin.cars.main;

import com.example.carsharingbackend.common.mvp.AbstractPresenter;
import com.example.carsharingbackend.common.mvp.IModel;
import com.example.carsharingbackend.common.mvp.IView;
import com.example.carsharingbackend.vaadinviews.admin.cars.filter.CarFilterPresenter;
import com.example.carsharingbackend.vaadinviews.admin.cars.grid.CarGridPresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class CarPresenter extends AbstractPresenter<CarPresenter.CarModel, CarPresenter.CarView> {
    public interface CarModel extends IModel {
    }

    public interface CarView extends IView {

        void setFirstComponent(Component... components);

        void setSecondComponent(Component... components);

    }

    private CarFilterPresenter filterPresenter;
    private CarGridPresenter gridPresenter;

    public CarPresenter(CarModel model, CarView view, CarFilterPresenter filterPresenter, CarGridPresenter gridPresenter) {
        super(model, view);
        this.filterPresenter = filterPresenter;
        this.gridPresenter = gridPresenter;
        bind();
    }

    @Override
    protected void bind() {
        filterPresenter.addApplyClickListener(e -> {
            gridPresenter.setFilter(filterPresenter.getFilterString());
        });
        view.setFirstComponent(filterPresenter.getView());
        view.setSecondComponent(gridPresenter.getView());
    }
}
