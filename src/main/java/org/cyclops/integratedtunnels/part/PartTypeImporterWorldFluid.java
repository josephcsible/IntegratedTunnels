package org.cyclops.integratedtunnels.part;

import com.google.common.collect.Lists;
import org.cyclops.integrateddynamics.api.part.aspect.IAspect;
import org.cyclops.integrateddynamics.core.part.aspect.AspectRegistry;
import org.cyclops.integrateddynamics.core.part.write.PartStateWriterBase;
import org.cyclops.integrateddynamics.part.aspect.Aspects;
import org.cyclops.integratedtunnels.core.part.PartTypeTunnelAspectsWorld;
import org.cyclops.integratedtunnels.part.aspect.TunnelAspects;

/**
 * A part that can import fluids from the world.
 * @author rubensworks
 */
public class PartTypeImporterWorldFluid extends PartTypeTunnelAspectsWorld<PartTypeImporterWorldFluid, PartStateWriterBase<PartTypeImporterWorldFluid>> {
    public PartTypeImporterWorldFluid(String name) {
        super(name);
        AspectRegistry.getInstance().register(this, Lists.<IAspect>newArrayList(
                TunnelAspects.Write.World.FLUID_BOOLEAN_IMPORT,
                TunnelAspects.Write.World.FLUID_FLUIDSTACK_IMPORT,
                TunnelAspects.Write.World.FLUID_LIST_IMPORT,
                TunnelAspects.Write.World.FLUID_PREDICATE_IMPORT
        ));
    }

    @Override
    protected PartStateWriterBase<PartTypeImporterWorldFluid> constructDefaultState() {
        return new PartStateWriterBase<PartTypeImporterWorldFluid>(Aspects.REGISTRY.getWriteAspects(this).size());
    }

    @Override
    public int getConsumptionRate(PartStateWriterBase<PartTypeImporterWorldFluid> state) {
        return state.hasVariable() ? 32 : super.getConsumptionRate(state);
    }
}