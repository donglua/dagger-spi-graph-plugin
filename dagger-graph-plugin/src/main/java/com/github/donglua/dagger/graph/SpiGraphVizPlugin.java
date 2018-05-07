package com.github.donglua.dagger.graph;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import dagger.model.BindingGraph;
import dagger.spi.BindingGraphPlugin;
import dagger.spi.DiagnosticReporter;

import javax.lang.model.element.TypeElement;
import java.util.stream.Collectors;


@AutoService(BindingGraphPlugin.class)
public class SpiGraphVizPlugin implements BindingGraphPlugin {

    @Override
    public void visitGraph(BindingGraph bindingGraph, DiagnosticReporter diagnosticReporter) {
        TypeElement componentElement =
                bindingGraph.rootComponentNode().componentPath().currentComponent();
        ClassName componentName = ClassName.get(componentElement);
        System.out.println(componentName.simpleName());
        for (BindingGraph.Node node : bindingGraph.nodes().stream().distinct().collect(Collectors.toList())) {
            System.out.println("  -- " + node.getClass().getSimpleName());
        }
    }
}
