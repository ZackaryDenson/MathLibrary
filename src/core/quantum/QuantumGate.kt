package core.quantum

import core.linear.UnitaryMatrix

class QuantumGate(val qubits: Int, members: Array<Array<out Any>>): UnitaryMatrix(members) {
    constructor(matrix: UnitaryMatrix): this(matrix.members.size.binaryLog, matrix.members)

    operator fun times(other: QuantumState) = QuantumState(super.times(other.column).column[0].vector)

    infix fun combine(other: QuantumGate) = QuantumGate(qubits + other.qubits, (this kronecker other).members)
}