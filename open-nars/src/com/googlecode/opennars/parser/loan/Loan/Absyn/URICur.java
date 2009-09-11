package com.googlecode.opennars.parser.loan.Loan.Absyn; // Java Package generated by the BNF Converter.

public class URICur extends URIRef {
  public final NSPrefix nsprefix_;
  public final String ident_;

  public URICur(NSPrefix p1, String p2) { nsprefix_ = p1; ident_ = p2; }

  public <R,A> R accept(com.googlecode.opennars.parser.loan.Loan.Absyn.URIRef.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof com.googlecode.opennars.parser.loan.Loan.Absyn.URICur) {
      com.googlecode.opennars.parser.loan.Loan.Absyn.URICur x = (com.googlecode.opennars.parser.loan.Loan.Absyn.URICur)o;
      return this.nsprefix_.equals(x.nsprefix_) && this.ident_.equals(x.ident_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.nsprefix_.hashCode())+this.ident_.hashCode();
  }


}