package com.example.carsharingbackend.vaadinviews.admin.carattributes.main;

import com.example.carsharingbackend.common.mvp.AbstractPresenter;
import com.example.carsharingbackend.common.mvp.IModel;
import com.example.carsharingbackend.common.mvp.IView;
import com.example.carsharingbackend.vaadinviews.admin.carattributes.grid.CarAttributeGridPresenter;
import com.example.carsharingbackend.vaadinviews.admin.carattributes.navigation.NavigationPresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class CarAttributePresenter extends AbstractPresenter<CarAttributePresenter.CarAttributeModel, CarAttributePresenter.CarAttributeView> {

    public interface CarAttributeModel extends IModel {

    }

    public interface CarAttributeView extends IView {
        void setFirstComponent(Component comp);

        void setSecondComponent(Component comp);
    }

    private NavigationPresenter navigationPresenter;
    private CarAttributeGridPresenter gridPresenter;

    public CarAttributePresenter(CarAttributeModel model, CarAttributeView view, CarAttributeGridPresenter gp, NavigationPresenter navPres) {
        super(model, view);
        gridPresenter = gp;
        navigationPresenter = navPres;
        bind();
    }


    @Override
    protected void bind() {
        view.setFirstComponent(navigationPresenter.getView());
        view.setSecondComponent(gridPresenter.getView());
        navigationPresenter.addValueChangeListener(e -> {
            gridPresenter.updateService(e.getValue().getClient());
        });
    }

    @Override
    public Component getView() {
        return view.mainLayout();
    }


}
