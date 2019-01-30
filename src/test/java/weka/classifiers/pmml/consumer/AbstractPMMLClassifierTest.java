package weka.classifiers.pmml.consumer;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import junit.framework.TestCase;
import weka.classifiers.evaluation.EvaluationUtils;
import weka.classifiers.evaluation.Prediction;
import weka.core.Attribute;
import weka.core.Instances;
import weka.core.pmml.PMMLFactory;
import weka.core.pmml.PMMLModel;

public abstract class AbstractPMMLClassifierTest extends TestCase {

  protected ArrayList<String> m_modelNames = new ArrayList<String>();
  protected ArrayList<String> m_dataSetNames = new ArrayList<String>();

  public AbstractPMMLClassifierTest(String name) {
    super(name);
  }

  public Instances getData(String name) {
    Instances elnino = null;
    try {
      elnino = new Instances(new BufferedReader(new InputStreamReader(
        ClassLoader.getSystemResourceAsStream("weka/classifiers/pmml/data/"
          + name))));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return elnino;
  }

  public PMMLClassifier getClassifier(String name) {
    PMMLClassifier regression = null;
    try {
      PMMLModel model = PMMLFactory.getPMMLModel(new BufferedInputStream(
        ClassLoader.getSystemResourceAsStream("weka/classifiers/pmml/data/"
          + name)));

      regression = (PMMLClassifier) model;

    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return regression;
  }
}
