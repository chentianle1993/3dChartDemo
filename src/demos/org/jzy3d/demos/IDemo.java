package org.jzy3d.demos;

import org.jzy3d.chart.Chart;

public interface IDemo {
	public String getName();
	public String getPitch();
	public Chart getChart() throws Exception;
	public void init() throws Exception;
    public boolean isInitialized();
    public boolean hasOwnChartControllers();
    /** Determine the canvas, awt, swing, offscreen.*/
    public String getCanvasType();
}
