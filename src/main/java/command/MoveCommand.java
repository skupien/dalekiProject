package command;

import model.World;
import model.utils.Direction;

public class MoveCommand extends Command {
    private final Direction direction;

    public MoveCommand(World world, Direction dir) {
        super(world);
        this.direction = dir;
    }

    @Override
    public boolean execute() {
        return world.makeMove(direction);
    }
}
