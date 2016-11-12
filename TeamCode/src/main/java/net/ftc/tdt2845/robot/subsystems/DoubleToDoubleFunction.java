package net.ftc.tdt2845.robot.subsystems;

/**
 * Created by Claudia on 11/12/2016.
 */

/**
 * Represents a function that accepts a double-valued argument and produces a
 * double-valued result.  This is the {@code double}-to-{@code double} primitive
 * specialization for {@link Function}.
 * <p>This is a functional interface whose functional method is {@link #applyAsDouble(double)}.
 *
 * @see Function
 * @author Randall Hauch
 */
public interface DoubleToDoubleFunction {

    /**
     * Applies this function to the given argument.
     *
     * @param value the function argument
     * @return the function result
     */
    public double applyAsDouble(double value);
}
