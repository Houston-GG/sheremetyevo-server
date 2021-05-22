package tech.visdom.sheremetyevo.exception;

public class RunwayUnitNotFoundException extends RuntimeException {
    public RunwayUnitNotFoundException(long id) { super("Unit with id: " + id + " not found.");}
}
