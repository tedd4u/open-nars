/*
 * EquivalenceAfter.java
 *
 * Copyright (C) 2008  Pei Wang
 *
 * This file is part of Open-NARS.
 *
 * Open-NARS is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * Open-NARS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Open-NARS.  If not, see <http://www.gnu.org/licenses/>.
 */
package nars.language;

import java.util.*;

import nars.inference.TemporalRules;
import nars.io.Symbols;
import nars.main.Memory;

/**
 * Temporal Implication relation, predicate after subject.
 */
public class EquivalenceAfter extends Equivalence implements Temporal {

    /**
     * constructor with partial values, called by make
     * @param n The name of the term
     * @param arg The component list of the term
     */
    public EquivalenceAfter(String n, ArrayList<Term> arg) {
        super(n, arg);
    }

    /**
     * Constructor with full values, called by clone
     * @param n The name of the term
     * @param cs Component list
     * @param open Open variable list
     * @param i Syntactic complexity of the compound
     */
    private EquivalenceAfter(String n, ArrayList<Term> cs, ArrayList<Variable> open, short i) {
        super(n, cs, open, i);
    }

    /**
     * Clone an object
     * @return A new object
     */
    @Override
    @SuppressWarnings("unchecked")
    public Object clone() {
        return new EquivalenceAfter(name, (ArrayList<Term>) cloneList(components), (ArrayList<Variable>) cloneList(openVariables), complexity);
    }

    /**
     * Try to make a new compound from two components. Called by the inference rules.
     * @param subject The first compoment
     * @param predicate The second compoment
     * @return A compound generated or null
     */
    public static EquivalenceAfter make(Term subject, Term predicate) {
        if (invalidStatement(subject, predicate)) {
            return null;
        }
        String name = makeStatementName(subject, Symbols.EQUIVALENCE_AFTER_RELATION, predicate);
        Term t = Memory.nameToListedTerm(name);
        if (t != null) {
            return (EquivalenceAfter) t;
        }
        ArrayList<Term> argument = argumentsToList(subject, predicate);
        return new EquivalenceAfter(name, argument);
    }

    /**
     * Get the operator of the term.
     * @return the operator of the term
     */
    @Override
    public String operator() {
        return Symbols.EQUIVALENCE_AFTER_RELATION;
    }

    /**
     * Check if the compound is communitative.
     * @return The components are temporally ordered
     */
    @Override
    public boolean isCommutative() {
        return false;
    }

    /**
     * Get the temporal order of the class
     * @return AFTER since the components are temporally ordered
     */
    @Override
    public TemporalRules.Relation getTemporalOrder() {
        return TemporalRules.Relation.AFTER;
    }
}