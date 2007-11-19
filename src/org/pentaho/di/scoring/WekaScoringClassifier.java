/*
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program; if not, write to the Free Software
 *    Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

/*
 *    WekaScoringClassifier.java
 *    Copyright 2007 Pentaho Corporation.  All rights reserved. 
 *
 */

package org.pentaho.di.scoring;

import weka.core.Instance;
import weka.classifiers.Classifier;

/**
 * Subclass of WekaScoringModel that encapsulates a Classifier.
 *
 * @author  Mark Hall (mhall{[at]}pentaho.org)
 * @version 1.0
 */
class WekaScoringClassifier extends WekaScoringModel {
  
  // The encapsulated classifier
  private Classifier m_model;
  
  /**
   * Creates a new <code>WekaScoringClassifier</code> instance.
   *
   * @param model the Classifier
   */
  public WekaScoringClassifier(Object model) {
    super(model);
  }
  
  /**
   * Set the Classifier model
   *
   * @param model a Classifier
   */
  public void setModel(Object model) {
      m_model = (Classifier)model;
  }

  /**
   * Return a classification (number for regression problems
   * or index of a class value for classification problems).
   *
   * @param inst the Instance to be classified (predicted)
   * @return the prediction (either a number for regression or
   * the index of a class-value for classification) as a double
   * @exception Exception if an error occurs
   */
  public double classifyInstance(Instance inst) throws Exception {
    return m_model.classifyInstance(inst);
  }

  /**
   * Return a probability distribution (over classes).
   *
   * @param inst the Instance to be predicted
   * @return a probability distribution
   * @exception Exception if an error occurs
   */  
  public double[] distributionForInstance(Instance inst)
    throws Exception {
    return m_model.distributionForInstance(inst);
  }

  /**
   * Returns true. Classifiers are supervised methods.
   *
   * @return true
   */
  public boolean isSupervisedLearningModel() {
    return true;
  }

  /**
   * Returns the textual description of the Classifier's model.
   *
   * @return the Classifier's model as a String
   */
  public String toString() {
    return m_model.toString();
  }
}
