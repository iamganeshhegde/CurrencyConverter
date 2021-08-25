package com.example.currencyconverter.linkedlist

import com.example.currencyconverter.miscellaneous.model.Employee

class EmployeeNode(employee: Employee) {
    constructor() : this(DUMMY)

    companion object{
        private var DUMMY = Employee(1, "aa","vv")
    }


    var employee:Employee = employee
    var next: EmployeeNode? = null
    var previous: EmployeeNode? = null

    override fun toString(): String {
        return employee.toString()
    }



}