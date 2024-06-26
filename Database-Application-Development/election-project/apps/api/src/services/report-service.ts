import { Handler } from 'express';
import * as report from '../controllers/report-controller';
import { BadRequestError } from '../errors/BadRequestError';
import z from 'zod';

export const society: Handler = async (req, res, next) => {
  try {
    if (!req.society) {
      throw new BadRequestError('Society ID missing from headers');
    }

    const societyReport = await report.societyReport({
      societyId: req.society.id,
    });

    res.json(societyReport);
  } catch (err) {
    next(err);
  }
};

export const system: Handler = async (req, res, next) => {
  try {
    const systemReport = await report.systemReport();
    res.json(systemReport);
  } catch (err) {
    next(err);
  }
};

const StatusParamsSchema = z.object({
  election_id: z.string().transform((id) => parseInt(id)),
});

export const status: Handler = async (req, res, next) => {
  try {
    const { election_id: electionId } = StatusParamsSchema.parse(req.params);
    const statusReport = await report.statusReport({ electionId });
    res.json(statusReport);
  } catch (err) {
    next(err);
  }
};

const ResultParamsSchema = z.object({
  election_id: z.string().transform((id) => parseInt(id)),
});

export const results: Handler = async (req, res, next) => {
  try {
    const { election_id: electionId } = ResultParamsSchema.parse(req.params);
    const resultsReport = await report.resultsReport({ electionId });
    res.json(resultsReport);
  } catch (err) {
    next(err);
  }
};
