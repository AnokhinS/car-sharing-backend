package com.example.carsharingbackend.vaadinviews.customer.main;

import com.example.carsharingbackend.common.mvp.AbstractPresenter;
import com.example.carsharingbackend.common.mvp.IModel;
import com.example.carsharingbackend.common.mvp.IView;
import com.example.carsharingbackend.vaadinviews.admin.cars.filter.CarFilterPresenter;
import com.example.carsharingbackend.vaadinviews.customer.carselection.CarSelectionPresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class CustomerActivityPresenter extends AbstractPresenter<CustomerActivityPresenter.CustomerActivityModel, CustomerActivityPresenter.CustomerActivityView> {

    public interface CustomerActivityModel extends IModel {
    }

    public interface CustomerActivityView extends IView {
        void addComponents(Component... components);
    }

    private CarFilterPresenter filterPresenter;
    private CarSelectionPresenter selectionPresenter;

    public CustomerActivityPresenter(CustomerActivityModel model, CustomerActivityView view, CarFilterPresenter filterPresenter, CarSelectionPresenter selectionPresenter) {
        super(model, view);
        this.filterPresenter = filterPresenter;
        this.selectionPresenter = selectionPresenter;
        bind();
    }

    @Override
    protected void bind() {
        filterPresenter.addApplyClickListener(e -> {
            selectionPresenter.setFilter(filterPresenter.getFilterString());
        });
        System.out.println(filterPresenter.getView());
        view.addComponents(filterPresenter.getView(), selectionPresenter.getView());
    }

}
