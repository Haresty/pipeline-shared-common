#!/bin/groovy
package hardesty

import hudson.model.Action

import hudson.scm.ChangeLogSet
import org.jenkinsci.plugins.workflow.graph.FlowNode
import org.jenkinsci.plugins.workflow.cps.nodes.StepStartNode
import org.jenkinsci.plugins.workflow.actions.LabelAction
import org.apache.tools.ant.types.selectors.SelectorUtils

import java.time.*

def init() {
  print "init ..."
}
