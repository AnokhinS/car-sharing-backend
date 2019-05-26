package com.example.carsharingbackend.carattributes.main;

import com.example.carsharingbackend.carattributes.grid.GridPresenter;
import com.example.carsharingbackend.carattributes.navigation.NavigationPresenter;
import com.example.carsharingbackend.common.AbstractPresenter;
import com.example.carsharingbackend.common.IModel;
import com.example.carsharingbackend.common.IView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class MainPresenter extends AbstractPresenter<MainPresenter.MainModel, MainPresenter.MainView> {

    public interface MainModel extends IModel {

    }

    public interface MainView extends IView {
        void setFirstComponent(Component comp);

        void setSecondComponent(Component comp);
    }

    private NavigationPresenter navigationPresenter;
    private GridPresenter gridPresenter;

    public MainPresenter(MainModel model,MainView view,GridPresenter gp, NavigationPresenter navPres) {
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
