package com.example.carsharingbackend.carattributes.main;

import com.example.carsharingbackend.common.AbstractPresenter;
import com.example.carsharingbackend.common.AttributeProvider;
import com.example.carsharingbackend.common.IModel;
import com.example.carsharingbackend.common.IView;
import com.example.carsharingbackend.entity.carinfo.Firm;
import com.example.carsharingbackend.entity.carinfo.Transmission;
import com.example.carsharingbackend.entity.carinfo.Type;
import com.example.carsharingbackend.carattributes.grid.GridPresenter;
import com.example.carsharingbackend.carattributes.navigation.NavigationPresenter;
import com.example.carsharingbackend.services.NamedBeanService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class MainPresenter extends AbstractPresenter<MainPresenter.MainModel, MainPresenter.MainView> {

    public interface MainModel extends IModel {
        NamedBeanService<Firm> getFirmService();

        NamedBeanService<Type> getTypeService();

        NamedBeanService<Transmission> getTransmissionService();
    }

    public interface MainView extends IView {
        void setFirstComponent(Component comp);

        void setSecondComponent(Component comp);
    }

    private NavigationPresenter navigationPresenter;
    private GridPresenter gridPresenter;
    private AttributeProvider attributeProvider;

    public MainPresenter(MainModel model,MainView view,GridPresenter gp, NavigationPresenter navPres, AttributeProvider attributeProvider) {
        super(model, view);
        gridPresenter = gp;
        navigationPresenter = navPres;
        this.attributeProvider = attributeProvider;
        bind();
    }


    @Override
    protected void bind() {
        view.setFirstComponent(navigationPresenter.getView());
        view.setSecondComponent(gridPresenter.getView());
        navigationPresenter.addValueChangeListener(e -> {
            gridPresenter.updateService(e.getValue().getService());
        });
    }

    @Override
    public Component getView() {
        return view.mainLayout();
    }


}
