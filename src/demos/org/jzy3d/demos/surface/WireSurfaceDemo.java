package org.jzy3d.demos.surface;

import org.jzy3d.chart.Chart;
import org.jzy3d.colors.Color;
import org.jzy3d.colors.ColorMapper;
import org.jzy3d.colors.colormaps.ColorMapRainbow;
import org.jzy3d.demos.AbstractDemo;
import org.jzy3d.demos.DemoLauncher;
import org.jzy3d.maths.Range;
import org.jzy3d.plot3d.builder.Builder;
import org.jzy3d.plot3d.builder.Mapper;
import org.jzy3d.plot3d.builder.concrete.OrthonormalGrid;
import org.jzy3d.plot3d.primitives.Shape;
import org.jzy3d.plot3d.rendering.canvas.Quality;

public class WireSurfaceDemo extends AbstractDemo {
    public static void main(String[] args) throws Exception {
        DemoLauncher.openDemo(new WireSurfaceDemo());
    }

    public WireSurfaceDemo() {
    }

    @Override
    public void init() {
        // Define a function to plot
        Mapper mapper = new Mapper() {
            public double f(double x, double y) {
                return 10 * Math.sin(x / 10) * Math.cos(y / 20) * x;
            }
        };

        // Define range and precision for the function to plot
        Range range = new Range(-150, 150);
        int steps = 50;

        // Create the object to represent the function over the given range.
        final Shape surface = Builder.buildOrthonormal(new OrthonormalGrid(range, steps, range, steps), mapper);
        surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), surface.getBounds().getZmin(), surface.getBounds().getZmax(), new Color(1, 1, 1, .5f)));
        surface.setFaceDisplayed(true);
        surface.setWireframeDisplayed(true);
        surface.setWireframeColor(Color.BLACK);

        // Create a chart and add surface
        chart = new Chart(Quality.Advanced, getCanvasType());
        chart.getScene().getGraph().add(surface);
    }

    @Override
    public String getPitch() {
        return "Show a simple surface based on a mathematical function";
    }
}
