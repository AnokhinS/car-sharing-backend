package com.example.carsharingbackend.view;



import com.example.carsharingbackend.vaadinviews.admin.carattributes.main.CarAttributePresenter;
import com.example.carsharingbackend.vaadinviews.admin.cars.main.CarPresenter;
import com.example.carsharingbackend.vaadinviews.admin.users.UserPresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("admin")

public class AdminView extends VerticalLayout {
    private Button attBtn = new Button("Параметры");
    private Button carsBtn = new Button("Автомобили");
    private Button usersBtn = new Button("Пользователи");
    private Button help = new Button("Help");

    private CarAttributePresenter attributePresenter;
    private CarPresenter carPresenter;
    private UserPresenter userPresenter;
    Component currentComponent = new VerticalLayout();

    public AdminView(CarAttributePresenter attributePresenter, CarPresenter carPresenter, UserPresenter userPresenter) {
        this.attributePresenter = attributePresenter;
        this.carPresenter = carPresenter;
        this.userPresenter = userPresenter;
        buildMainLayout();

        add(currentComponent);
        attBtn.addClickListener(e->{
            replace(currentComponent,attributePresenter.getView());
            currentComponent=attributePresenter.getView();
        });
        carsBtn.addClickListener(e->{
            replace(currentComponent,carPresenter.getView());
            currentComponent=carPresenter.getView();
        });
        usersBtn.addClickListener(e->{
            replace(currentComponent,userPresenter.getView());
            currentComponent=userPresenter.getView();
        });
    }

    private void buildMainLayout() {
        setSizeFull();
        add(createToolbar());
    }


    public HorizontalLayout createToolbar() {
        HorizontalLayout lo = new HorizontalLayout();
        lo.add(attBtn);
        lo.add(carsBtn);
        lo.add(usersBtn);
        lo.add(help);
        return lo;
    }

}

