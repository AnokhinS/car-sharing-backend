package com.example.carsharingbackend.view;



import com.example.carsharingbackend.carattributes.grid.GridPresenter;
import com.example.carsharingbackend.services.NamedBeanService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.Route;

@Route("admin")
public class AdminView extends VerticalLayout {

    private GridPresenter.GridModel model;
    //private ListBox list = new NavigationViewImpl();
    private MainView mainView;
    private NamedBeanService currentService;

    private Button newContact = new Button("Add contact");
    private Button search = new Button("Search");
    private Button share = new Button("Share");
    private Button help = new Button("Help");


    public AdminView(GridPresenter.GridModel model, MainView view) {
        this.model = model;
        this.mainView = view;
        buildMainLayout();
//        mainView.getGrid().setItems(model.getFirmService().getAllOrdered());
        mainView.getFilter().addValueChangeListener(e->{
            getGrid().setItems(currentService.getAllStartsWith(e.getValue()));
        });
    }




    private SplitLayout createMainSplit() {
        SplitLayout horizontalSplit = new SplitLayout();
        horizontalSplit.setSizeFull();
        horizontalSplit.setSplitterPosition(400);

//        list.addValueChangeListener(event -> {
//            switch (event.getValue().toString()) {
//                case NavigationViewImpl.FIRMS:
//                    currentService = model.getFirmService();
//                    getGrid().setItems(currentService.getAllOrdered());
//                    break;
//                case NavigationViewImpl.TYPES:
//                    currentService = model.getTypeService();
//                    getGrid().setItems(currentService.getAllOrdered());
//                    break;
//                case NavigationViewImpl.TRANSMISSIONS:
//                    currentService = model.getTransmissionService();
//                    getGrid().setItems(currentService.getAllOrdered());
//                    break;
//            }
//        });
    //    horizontalSplit.addToPrimary(list);
        horizontalSplit.addToSecondary(mainView);
        return horizontalSplit;
    }

    private Grid getGrid() {
        return mainView.getGrid();
    }

    private void buildMainLayout() {
        setSizeFull();
        add(createToolbar());
        add(createMainSplit());
    }


    public HorizontalLayout createToolbar() {
        HorizontalLayout lo = new HorizontalLayout();
        lo.add(newContact);
        lo.add(search);
        lo.add(share);
        lo.add(help);
        return lo;
    }

}

