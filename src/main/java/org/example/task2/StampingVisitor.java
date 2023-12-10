package org.example.task2;
public class StampingVisitor {
    public static <T> Group<T> stamp(Group<T> group) {

        group.getTasks().forEach(task -> {

            if (task instanceof Signature) {
                Signature<T> signature = (Signature<T>) task;
                signature.setHeader("groupId", group.getGroupUuid());

            } else if (task instanceof Group) {
                stamp((Group<T>) task);
            }
        });

        return group;
    }
}