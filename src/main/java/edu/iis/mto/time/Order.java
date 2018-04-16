package edu.iis.mto.time;

import java.time.Clock;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.HOURS;

public class Order {
	private static final long VALID_PERIOD_HOURS = 24;
	private State orderState;
	private List<OrderItem> items = new ArrayList<OrderItem>();
	private Instant submitionDate;
	private Clock clock;

	public Order() {
		orderState = State.CREATED;
		clock = Clock.systemDefaultZone();
	}

	public void addItem(OrderItem item) {
		requireState(State.CREATED, State.SUBMITTED);

		items.add(item);
		orderState = State.CREATED;

	}

	public void submit() {
		requireState(State.CREATED);

		orderState = State.SUBMITTED;
		submitionDate = clock.instant();
	}

	public void confirm() {
		requireState(State.SUBMITTED);
		Instant now = clock.instant();
		Instant deadline = submitionDate.plus(VALID_PERIOD_HOURS, HOURS);
		if(now.isAfter(deadline)){
			orderState = State.CANCELLED;
			throw new OrderExpiredException();
		}
	}

	public void realize() {
		requireState(State.CONFIRMED);
		orderState = State.REALIZED;
	}

	State getOrderState() {
		return orderState;
	}
	
	private void requireState(State... allowedStates) {
		for (State allowedState : allowedStates) {
			if (orderState == allowedState)
				return;
		}

		throw new OrderStateException("order should be in state "
				+ allowedStates + " to perform required  operation, but is in "
				+ orderState);

	}

	public static enum State {
		CREATED, SUBMITTED, CONFIRMED, REALIZED, CANCELLED
	}
}
