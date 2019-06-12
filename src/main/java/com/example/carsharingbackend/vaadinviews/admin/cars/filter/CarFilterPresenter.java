package com.example.carsharingbackend.vaadinviews.admin.cars.filter;

import com.example.carsharingbackend.common.mvp.AbstractPresenter;
import com.example.carsharingbackend.common.mvp.IModel;
import com.example.carsharingbackend.common.mvp.IView;
import com.example.carsharingbackend.vaadinviews.admin.cars.filter.impl.CarFilterViewImpl;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.context.annotation.Scope;

import java.util.Collection;

@SpringComponent
@Scope(value = "prototype")
public class CarFilterPresenter extends AbstractPresenter<CarFilterPresenter.CarFilterModel, CarFilterPresenter.CarFilterView> {

    public CarFilterPresenter(CarFilterModel model) {
        super(model, new CarFilterViewImpl(model.getFirms(), model.getTypes(), model.getTransmissions()));
        bind();
    }

    public interface CarFilterView extends IView {
        Button getApplyButton();

        String getFilterString();
    }

    public interface CarFilterModel extends IModel {
        Collection getFirms();

        Collection getTypes();

        Collection getTransmissions();

    }

    @Override
    protected void bind() {

    }

    public String getFilterString() {
        return view.getFilterString();
    }

    public void addApplyClickListener(ComponentEventListener listener) {
        view.getApplyButton().addClickListener(listener);
        view.getApplyButton().addClickListener(e-> System.out.println(view.toString()));
    }
}
