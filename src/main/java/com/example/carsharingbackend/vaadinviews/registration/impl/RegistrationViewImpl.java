package com.example.carsharingbackend.vaadinviews.registration.impl;

import com.example.carsharingbackend.entity.userinfo.User;
import com.example.carsharingbackend.utils.PageWrapper;
import com.example.carsharingbackend.vaadinviews.registration.RegistrationPresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.binder.Validator;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;


@SpringComponent
@UIScope
public class RegistrationViewImpl extends Dialog implements RegistrationPresenter.RegistrationView {

    private Binder<User> binder = new Binder<>();
    private Span label = new Span(new H3("Регистрация"));
    private TextField firstName = new TextField("Имя", "Иван");
    private TextField lastName = new TextField("Фамилия", "Иванов");
    private EmailField email = new EmailField("Email");
    private PasswordField password = new PasswordField("Пароль");
    private PasswordField confirmPassword = new PasswordField("Повторите пароль");


    private Button submitBtn = new Button("Зарегистрироваться");

    private HorizontalLayout actions = new HorizontalLayout(submitBtn);

    private User newUser = new User();

    public RegistrationViewImpl() {
        setWidth("350px");

        label.setWidthFull();
        firstName.setWidthFull();
        lastName.setWidthFull();
        email.setWidthFull();
        password.setWidthFull();
        confirmPassword.setWidthFull();

        binder.forField(firstName)
                .withValidator(firstName -> firstName.length() >= 2, "Слишком короткое имя")
                .bind(User::getFirstName, User::setFirstName);
        binder.forField(lastName)
                .withValidator(firstName -> firstName.length() >= 2, "Слишком короткая фамилия")
                .bind(User::getLastName, User::setLastName);
        binder.forField(email)
                .withValidator(new EmailValidator("Неверный формат"))
                .bind(User::getEmail, User::setEmail);
        binder.forField(password)
                .withValidator(pw-> pw.length()>=4, "Слишком простой пароль")
                .bind(User::getPassword, User::setPassword);
        binder.forField(confirmPassword)
                .withValidator(new PasswordValidator())
                .bind(User::getPassword, User::setPassword);

        submitBtn.addClickListener(e -> {
            binder.writeBeanIfValid(newUser);

            if(binder.isValid()){
                getUI().get().navigate("login");
            }

        });

        VerticalLayout layout = new VerticalLayout();
        layout.add(label, firstName, lastName, email, password, confirmPassword, actions);
        add(layout);
    }

    private class PasswordValidator implements Validator<String> {
        @Override
        public ValidationResult apply(String s, ValueContext valueContext) {
            if (!password.getValue().equals(confirmPassword.getValue())) {
                return ValidationResult.error("Пароли не совпадают");
            } else return ValidationResult.ok();
        }
    }


    @Override
    public Button getSubmitBtn() {
        return submitBtn;
    }

    @Override
    public void openDialog() {
        this.open();
    }

    @Override
    public User getNewUser() {
        if (newUser.getFirstName() == null) {
            return null;
        } else {
            return newUser;
        }

    }

    @Override
    public Component mainLayout() {
        return new PageWrapper(this);
    }
}
