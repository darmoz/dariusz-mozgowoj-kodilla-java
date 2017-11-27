package com.kodilla.spring.vaadin.example2;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = SummaryView.NAME)
public class SummaryView extends VerticalLayout implements View {


        public final static String NAME = "";
        VerticalLayout summaryLayout = new VerticalLayout();
        Label label = new Label("summary form");

}
