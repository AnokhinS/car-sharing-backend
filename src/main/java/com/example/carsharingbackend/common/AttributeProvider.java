package com.example.carsharingbackend.common;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttributeProvider {
    private List<AttributeService> attrs;

    public AttributeProvider(FirmAttributeService f, TypeAttributeService ty, TransmissionAttributeService tr) {
        attrs = new ArrayList<>();
        attrs.add(f);
        attrs.add(ty);
        attrs.add(tr);
    }

    public List<AttributeService> getAttributes() {
        return attrs;
    }
}
