package com.example.carsharingbackend.carattributes.grid.impl;

import com.example.carsharingbackend.entity.common.NamedBean;
import com.example.carsharingbackend.carattributes.grid.GridPresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.selection.SelectionListener;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.Getter;

import java.util.Collection;

@SpringComponent
@UIScope
public class GridViewImpl extends VerticalLayout implements GridPresenter.GridView {
    @Getter
    private TextField filter;
    @Getter
    private Button addNewBtn;
    private Grid<NamedBean> grid;
    private VerticalLayout editor;


    public GridViewImpl() {
        filter = new TextField();
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.setPlaceholder("Фильтрация по названию");
        filter.setWidth("300px");
        addNewBtn = new Button("Добавить...", VaadinIcon.PLUS.create());
        grid = new Grid<>();
        grid.addColumn(NamedBean::getId).setHeader("Идентификатор").setSortable(true).setWidth("80px");
        grid.addColumn(NamedBean::getName).setHeader("Название").setSortable(true);

        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        add(actions, grid);

    }

    @Override
    public Component mainLayout() {
        return this;
    }

    @Override
    public void setData(Collection<NamedBean> list) {
        grid.setItems(list);
    }

    @Override
    public Button getAddBtn() {
        return addNewBtn;
    }

    @Override
    public void setEditor(VerticalLayout vl) {
        editor = vl;
        add(editor);
    }

    @Override
    public void setSingleSelectListener(SelectionListener listener) {
        grid.addSelectionListener(listener);
    }

}
