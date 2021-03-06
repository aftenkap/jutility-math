package org.jutility.math.geometry;


//@formatter:off
/*
* #%L
 * * jutility-math
 * *
 * %%
 * Copyright (C) 2013 - 2014 jutility.org
 * *
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
*/
//@formatter:on


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;


/**
 * The {@code IScaleFactor} interface provides a contract for classes
 * implementing scaling in three dimensions.
 * 
 * @param <T>
 *            the {@link Number} type of the {@code IScaleFactor}.
 * 
 * @author Peter J. Radics
 * @version 0.1.2
 * @since 0.1.0
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY,
        property = "implementingType")
@JsonSubTypes({ @JsonSubTypes.Type(value = ScaleFactor.class,
        name = "ScaleFactor") })
public interface IScaleFactor<T extends Number> {

    /**
     * Returns the type of this scale.
     * 
     * @return the type.
     */
    Class<? extends T> getType();

    /**
     * Returns the scale factor for the x-dimension.
     * 
     * @return the scale factor.
     */
    T getScaleFactorX();


    /**
     * Returns the scale factor for the y-dimension.
     * 
     * @return the scale factor.
     */
    T getScaleFactorY();


    /**
     * Returns the scale factor for the z-dimension.
     * 
     * @return the scale factor.
     */
    T getScaleFactorZ();
}

