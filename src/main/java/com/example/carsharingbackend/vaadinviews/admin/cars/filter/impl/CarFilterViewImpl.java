package com.example.carsharingbackend.vaadinviews.admin.cars.filter.impl;

import com.example.carsharingbackend.utils.StringUtils;
import com.example.carsharingbackend.utils.UriBuilder;
import com.example.carsharingbackend.vaadinviews.admin.cars.filter.CarFilterPresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CarFilterViewImpl extends VerticalLayout implements CarFilterPresenter.CarFilterView {
    private String filterString = "";
    private Button applyButton;
    private Button clearButton;
    private CustomMultiBox firmBox;
    private CustomMultiBox typeBox;
    private CustomMultiBox transmissionBox;
    private Span title;

    public CarFilterViewImpl(Collection firms, Collection types, Collection transmissions) {
        title = new Span(new H3("Фильтр"));
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setWidth("400px");
        firmBox = new CustomMultiBox("Производитель", firms);
        typeBox = new CustomMultiBox("Тип", types);
        transmissionBox = new CustomMultiBox("Коробка передач", transmissions);
        NumberRange cost = new NumberRange("Цена, руб.", 50d, 0, 99999, 5);
        NumberRange year = new NumberRange("Год выпуска", 2000, 1950, 2019, 1);

        applyButton = new Button("Применить");
        applyButton.addClickListener(c -> {
            String firmQuery = StringUtils.toQueryParam(firmBox.selected);
            String typeQuery = StringUtils.toQueryParam(typeBox.selected);
            String trQuery = StringUtils.toQueryParam(transmissionBox.selected);
            UriBuilder uriBuilder = new UriBuilder(filterString);
            uriBuilder.requestParam("firms", firmQuery);
            uriBuilder.requestParam("types", typeQuery);
            uriBuilder.requestParam("transmissions", trQuery);
            uriBuilder.requestParam("costFrom", cost.getFrom());
            uriBuilder.requestParam("costTo", cost.getTo());
            uriBuilder.requestParam("yearFrom", year.getFrom());
            uriBuilder.requestParam("yearTo", year.getTo());
            filterString = uriBuilder.getUri();
        });
        clearButton = new Button("Сбросить", e -> collapseAll());

        HorizontalLayout buttons = new HorizontalLayout(applyButton, clearButton);

        add(title, cost, year, firmBox, typeBox, transmissionBox, buttons);
    }


    private void collapseAll() {
        firmBox.collapse();
        typeBox.collapse();
        transmissionBox.collapse();
        filterString = "";
    }

    @Override
    public Button getApplyButton() {
        return applyButton;
    }

    @Override
    public String getFilterString() {
        String result = filterString;
        filterString = "";
        return result;
    }

    @Override
    public Component mainLayout() {
        return this;
    }

    private class CustomMultiBox extends VerticalLayout {
        private boolean isVisible = false;
        @Getter
        private Collection<String> selected;
        VerticalLayout hiddenContent;

        private void collapse() {
            checkboxes.forEach(e -> e.setValue(false));
            hiddenContent.setVisible(false);
            selected = new HashSet<>();
        }

        ArrayList<Checkbox> checkboxes;

        public CustomMultiBox(String attributeName, Collection entities) {
            checkboxes = new ArrayList<>();
            selected = new HashSet<>();
            hiddenContent = new VerticalLayout();
            Collection<String> items = StringUtils.toStringCollection(entities);

            items.forEach(e -> {
                Checkbox checkbox = new Checkbox(e);
                checkbox.addClickListener(t -> {
                    if (checkbox.getValue() == true) {
                        selected.add(e);
                    } else {
                        selected.remove(e);
                    }
                });
                hiddenContent.add(checkbox);
                checkboxes.add(checkbox);
            });
            Button showFirms = new Button(attributeName);
            showFirms.addClickListener(e -> {
                hiddenContent.setVisible(!isVisible);
                isVisible = !isVisible;
            });
            add(showFirms, hiddenContent);
            hiddenContent.setVisible(isVisible);

            getElement().getStyle().set("border", "1px solid #9E9E9E");


        }

    }


    private class NumberRange extends VerticalLayout {
        private NumberField from;
        private NumberField to;


        public NumberRange(String labelString, double defValue, double min, double max, double step) {
            Label label = new Label(labelString);
            from = new NumberField("от");
            from.setPlaceholder("" + (int) defValue);
            from.setMin(min);
            from.setMax(max);
            from.setStep(step);
            from.setHasControls(true);
            to = new NumberField("до");
            to.setPlaceholder("" + (int) defValue);
            to.setMin(min);
            to.setMax(max);
            to.setStep(step);
            to.setHasControls(true);
            HorizontalLayout fromTo = new HorizontalLayout(from, to);
            add(label, fromTo);
        }

        public double getFrom() {
            return from.getValue() == null ? from.getMin() : from.getValue();
        }

        public double getTo() {
            return to.getValue() == null ? to.getMax() : to.getValue();
        }
    }


}
