package com.example.carsharingbackend.common;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttributeProvider {
    private List<AttributeClient> attrs;

    public AttributeProvider(FirmAttributeClient f, TypeAttributeClient ty, TransmissionAttributeClient tr) {
        attrs = new ArrayList<>();
        attrs.add(f);
        attrs.add(ty);
        attrs.add(tr);
    }

    public List<AttributeClient> getAttributes() {
        return attrs;
    }
}
