package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		for (int i = 0; i < array.length; i++) {
			this.insert(array[i]);
		}

		return floorAux(numero, null);
	}

	private Integer floorAux(double taget, Integer floor) {
		Integer root = this.extractRootElement();

		if (root != null) {
			if (taget >= root && (floor == null || root >= floor)) {
				floor = this.floorAux(taget, root);
			} else {
				floor = this.floorAux(taget, floor);
			}
		}

		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		for (int i = 0; i < array.length; i++) {
			this.insert(array[i]);
		}

		return this.floorAux(numero, null);
	}

	private Integer ceilAux(double target, Integer ceil) {
		Integer root = this.extractRootElement();

		if (root != null) {
			if (target <= root && (ceil == null || root <= ceil)) {
				ceil = this.ceilAux(target, root);
			} else {
				ceil = this.ceilAux(target, ceil);
			}
		}

		return ceil;
	}

}
